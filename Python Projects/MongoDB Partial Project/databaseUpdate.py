import pymongo
import csv
import datetime

DB = "SunSpot"
WEATHERCOLL = "weather"
LOADCOLL = "load_data"
WEATHEROUTPUTCSV = 'output.csv'



def weatherParse():
    with open(WEATHEROUTPUTCSV, newline = '') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar = '|')
        lastLine = []
        for row in spamreader:
            lastLine = row
        temp = lastLine[0].split(',')
        if(len(temp[1]) == 3):
            return({'date':temp[0], 'time':('0'+temp[1]), 'temp':temp[3]})
        else: return({'date':temp[0], 'time':temp[1], 'temp':temp[3]})

def loadParse(wtime):
    with open('systemstatus.csv') as csvfile:
        spamreader = csv.reader(csvfile, delimiter=' ', quotechar = '|')
        tempList = []
        for row in spamreader:
            if(len(tempList) == 0):
                timeList = row[3].split(':')
                time = timeList[0] + timeList[1]
                timeString = row[1] + row[2] + row[4]
                dateObj = datetime.datetime.strptime(timeString, '%b%d%Y')
                dateStr = str(dateObj).split(' ')[0]
                tempList = tempList + [dateStr, time]
            else:
                tempList.append(row[-1].split(',')[-1])
        if(len(tempList[1]) == 3):
            return({'date':tempList[0], 'time':('0'+wtime), 'expected_load':tempList[4]})
        else: return({'date':tempList[0], 'time':wtime, 'expected_load':tempList[4]})
            
    
def update():
    try:
        connection=pymongo.MongoClient()
        print("Connection successful")
    except pymongo.errors.ConnectionFailure as e:
        print("Connection failed % s" % e)
    
    db = eval("connection.{}".format(DB))
    coll = eval("db.{}".format(WEATHERCOLL))
    weather = weatherParse()
    print(weather)
    time = weather['time']
    coll.insert_one(weather)
    coll = eval("db.{}".format(LOADCOLL))
    loadData = loadParse(time)
    print(loadData)
    coll.insert_one(loadData)
    print("Data successfully updated")

if __name__ == '__main__':
    update()