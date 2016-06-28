#ifndef listTemp_H
#define listTemp_H
class InvalidIndexException{};
class EmptyListException{};
class FullListException{};

template <class T>
class list {
public:
	list();
	T at(int i);
	bool empty();
	T first();
	T last();
	void insert(T item);
	void remove(int i);
private:
	int length;
	T elements[10];
	int size;
};

template <class T>
list<T>::list() {
	size = 0;
	length = 10;
	elements[10] = {};
}

template <class T>
T list<T>::at(int i){
	if (size < i+1){
		throw InvalidIndexException();
	}
	else return elements[i];
}

template <class T>
bool list<T>::empty(){
	if (size == 0){
		return true;
	}
	else{
		return false;
	}
}

template <class T>
T list<T>::first(){
	if (size == 0){
		throw EmptyListException();
	}
	else return elements[0];
}

template <class T>
T list<T>::last(){
	if (size == 0){
		throw EmptyListException();
	}
	else return elements[size - 1];
}

template <class T>
void list<T>::insert(T item){
	if (size == length){
		throw FullListException();
	}
	elements[size] = item;
	size++;
}

template <class T>
void list<T>::remove(int i){
	if (size < i+1){
		throw InvalidIndexException();
	}
	else{
		for (int j = i; j < size; j++){
			elements[j] = elements[j + 1];
		}
		elements[size] = NULL;
		size--;
	}
}

#endif