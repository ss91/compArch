#! /bin/bash

if [ "$#" -ne 4 ]; then
    echo "Usage: bash $0 <# of integers> <C executable> <Java executable> <Python script> "
	exit
fi

STR_C="c_output_$1"
STR_JAVA="java_output_$1"
STR_PYTHON="python_output_$1"

for i in {1..10}
do
		
	echo "Iteration $i" >> $STR_C
	echo "Iteration $i" >> $STR_JAVA
	echo "Iteration $i" >> $STR_PYTHON
		
	3>>$STR_C perf stat --log-fd 3 ./$2 $1 > /dev/null
	3>>$STR_JAVA perf stat --log-fd 3 java $3 $1 > /dev/null
	3>>$STR_PYTHON perf stat --log-fd 3 python $4 $1 > /dev/null

done

	
