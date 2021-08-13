#! /bin/bash
l=`head -n 1 file.txt | wc -w`

for ((i=1;i<=$l;i++)); do
    awk -v arg=$i '{print $arg}' file.txt | xargs
done
