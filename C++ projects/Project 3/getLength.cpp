int getLength(int grid[][6], int rowSize){
	int count = 0;
	for (int i = 0; i < rowSize; i++){
		for (int j = 0; j < 6; j++){
			count++;
		}
	}
	return count;
}