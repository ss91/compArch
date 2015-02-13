#! /bin/bash

if [ "$#" -ne 7 ]; then
    echo "Usage: bash $0 <# of integers> <C executable_gcc> <Java executable> <Python script> <C_executable_clang> <C executable_gcc_optimized> <C_executable_clang_optimized>"
	exit
fi



STR_C_GCC="gcc_output_$1"
STR_JAVA="java_output_$1"
STR_PYTHON="python_output_$1"
STR_C_CLANG="clang_output_$1"
STR_C_GCC_OPTIMIZED="gcc_output_optimized_$1"
STR_C_CLANG_OPTIMIZED="clang_output_optimized_$1"

for i in {1..10}
do
		
	echo "Iteration $i" >> $STR_C_GCC
	echo "Iteration $i" >> $STR_JAVA
	echo "Iteration $i" >> $STR_PYTHON
	echo "Iteration $i" >> $STR_C_CLANG	
	echo "Iteration $1" >> $STR_C_GCC_OPTIMIZED
	echo "Iteration $1" >> $STR_C_CLANG_OPTIMIZED

	3>>$STR_C_GCC perf stat --log-fd 3 ./$2 $1 > /dev/null
	3>>$STR_JAVA perf stat --log-fd 3 java $3 $1 > /dev/null
	3>>$STR_PYTHON perf stat --log-fd 3 python $4 $1 > /dev/null
	3>>$STR_C_CLANG perf stat --log-fd 3 ./$5 $1 > /dev/null
	3>>$STR_C_GCC_OPTIMIZED perf stat --log-fd 3 ./$6 $1 > /dev/null
	3>>$STR_C_CLANG_OPTIMIZED perf stat --log-fd 3 ./$7 $1 > /dev/null
done

	
