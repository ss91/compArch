#! /bin/bash

if [ "$#" -ne 4 ]; then
    echo "Usage: bash $0 <# of integers> <C executable_gcc> <Java executable> <C_executable_clang> "
	exit
fi



STR_C_GCC="gcc_output_$1"
STR_JAVA="java_output_$1"
#STR_PYTHON="python_output_$1"
STR_C_CLANG="clang_output_$1"
for i in {1..10}
do
		
	echo "Iteration $i" >> $STR_C_GCC
	echo "Iteration $i" >> $STR_JAVA
	#echo "Iteration $i" >> $STR_PYTHON
	echo "Iteration $i" >> $STR_C_CLANG	
	3>>$STR_C_GCC perf stat --log-fd 3 ./$2 $1 > /dev/null
	3>>$STR_JAVA perf stat --log-fd 3 java $3 $1 > /dev/null
	3>>$STR_C_CLANG perf stat --log-fd 3 ./$4 $1 > /dev/null
done
