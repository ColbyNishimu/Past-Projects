from pymongo import *
import numpy as np
import array
import random
import csv
import pymongo
import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email_alert_sys import send_email




#Globals
DB = "SunSpot"
EMAILCOLL = "emails"
LOADDATACOLL = "load_data"
WEATHERCOLL = "weather"
PREDICTIONCOLL = 'predictions'
PREDICTIONOUTPUTCSV = "test_predictions.csv"


class dataPuller(object):
    
    

    def __init__(self):
        try:
            self.connection= MongoClient()
        except errors.ConnectionFailure as e:
            pass
        self.db = eval("self.connection.{}".format(DB))
    
    
    def emailPull(self, city):
        self.coll = eval("self.db.{}".format(EMAILCOLL))
        qresult = self.coll.find({"city": city})
        return qresult.next()['emails']
        
    def predictDataPush(self, query):
        self.coll = eval("self.db.{}".format(PREDICTIONCOLL))
        self.coll.insert(query)
        print("Successfully added prediction")
    
    def predictDataPull(self, *args):
        date = ''
        expected = ''
        time = ''
        actual = ''
        temp = ''
        with open("test_data.csv", "w", newline="") as writer:
            w = csv.writer(writer, delimiter=",")
            w.writerow(["date", "expected", "time", "actual", "temp"])
            for query in args:
                self.coll = eval("self.db.{}".format(LOADDATACOLL))
                qresult = list(self.coll.find(query))
                for k in list(qresult):
                    date = k.get("date")
                    expected = k.get("expected")
                    time = k.get("time")
                    actual = k.get("actual")
                    self.coll = eval("self.db.{}".format(WEATHERCOLL))
                    rresult = self.coll.find({"time": time, "date": date})
                    for j in rresult:
                        temp = j.get("temp")
                        w.writerow([date, expected, time, actual, temp])
        writer.close
    
    def numpyArrayCreate(self):
        result = []
        self.coll = eval("self.db.{}".format(LOADDATACOLL))
        ldcoll = self.coll.find()
        ldlist = list(ldcoll)
        print(ldlist)
        self.coll = eval("self.db.{}".format(WEATHERCOLL))
        wcoll = self.coll.find()
        wlist = list(wcoll)
        print(wlist)
        i = 0
        for j in ldlist:
            temp1 = j['expected_load']
            temp2 = wlist[i]['temp']
            tempArray = [temp2, temp1]
            result = result + [tempArray]
            i = i+1
        numArray = np.array(result)
        print(repr(numArray))
        return numArray
    
    def numpyToCSV(self):
        result = []
        self.coll = eval("self.db.{}".format(LOADDATACOLL))
        ldcoll = self.coll.find()
        ldlist = list(ldcoll)
        print(ldlist)
        self.coll = eval("self.db.{}".format(WEATHERCOLL))
        wcoll = self.coll.find()
        wlist = list(wcoll)
        print(wlist)
        i = 0
        for j in ldlist:
            temp1 = j['expected_load']
            temp2 = wlist[i]['temp']
            tempArray = [temp2, temp1]
            result = result + [tempArray]
            i = i+1
        with open("test_data.csv", "w", newline="") as writer:
            w = csv.writer(writer, delimiter=",")
            w.writerow(["temp", "actual_load"])
            for k in range(len(result)):
                w.writerow([result[k][0], result[k][1]])
            writer.close
        
    
    def graphPull(self, *args):
        with open("graph_data.csv", "w", newline="") as writer:
            w = csv.writer(writer, delimiter=",")
            w.writerow(["datetime", "expected", "actual", "temp", "predicted"])
            for query in args:
                date = ''
                time = ''
                expected = ''
                actual = ''
                temp = ''
                predicted = ''
                self.coll = eval("self.db.{}".format(LOADDATACOLL))
                qresult = list(self.coll.find(query).sort([("date", pymongo.ASCENDING), ("time", pymongo.ASCENDING)]))
                for k in list(qresult):
                    datetime = ''
                    date = k.get("date")
                    time = k.get("time")
                    tempdate = date.split("-")
                    for i in tempdate:
                        datetime =datetime + i
                    datetime =datetime + k.get("time")
                    expected = k.get("expected")
                    actual = k.get("actual")
                    self.coll = eval("self.db.{}".format(WEATHERCOLL))
                    wresult = self.coll.find({"time": time, "date": date})
                    self.coll = eval("self.db.{}".format(PREDICTIONCOLL))
                    presult = self.coll.find({"time": time, "date": date})
                    for j in wresult:
                        temp = j.get("temp")
                    for p in presult:
                        predicted = p.get("prediction")   
                        w.writerow([datetime, expected, actual, temp, predicted])
        writer.close
    
    def emailPush(self, city, email):
        self.coll = eval("self.db.{}".format(EMAILCOLL))
        self.coll.update({'city': city}, {"$addToSet":{"emails": email}}, upsert=True)

    
    def emailDelete(self, city, email):
        self.coll = eval("self.db.{}".format(EMAILCOLL))
        self.coll.update({"city": city}, {"$pull": {"emails": email}})
    
    def predictionUpdate(self):
        with open(PREDICTIONOUTPUTCSV, newline = '') as csvfile:
            count = 0
            spamreader = csv.reader(csvfile, delimiter=' ', quotechar = '|')
            self.coll = eval("self.db.{}".format(PREDICTIONCOLL))
            for row in spamreader:
                result = row[0].split(",")
                if(count == 0):
                    count = count +1
                    continue
                else:
                    if(len(result[2]) == 3):
                        self.coll.insert({'date':result[0], 'expected':result[1], 'time':('0'+result[2]), 'actual':result[3], 'temp':result[4], 'prediction':int(float(result[5])), 'prediction_improvement':result[8]})
                    else: self.coll.insert({'date':result[0], 'expected':result[1], 'time':result[2], 'actual':result[3], 'temp':result[4], 'prediction':int(float(result[5])), 'prediction_improvement':result[8]})
        
    def emailSend(self, ourPredict, CAISOPredict, city):
        difference = ourPredict - CAISOPredict
        self.coll = eval("self.db.{}".format(EMAILCOLL))
        if(difference > 1000 or difference < -1000):
            recipients_list = list(self.coll.find({"city": city}, {"emails": 1, "_id": 0}))[0]["emails"]
            send_email.send_email(recipients_list)
        