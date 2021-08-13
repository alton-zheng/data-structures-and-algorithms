# Read from the file file.txt and print its transposed content to stdout.
# 194. Transpose File #303

line=$(cat file.txt | head -n 1 | wc -w)
for i in $(seq 1 $line)
do
    awk '{print $'''$i'''}' file.txt | xargs
done