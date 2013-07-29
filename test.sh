#!/bin/sh

echo "Calling Alert component (CTRL+c to quit)..."

for (( ; ; ))
do
   curl http://localhost:8812/
   NUMBER=$[ ( $RANDOM % 10 )  + 1 ]
   echo "  Next call in $NUMBER sec"
   sleep $NUMBER
done
