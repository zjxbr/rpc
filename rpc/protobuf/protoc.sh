#!/bin/bash
if [ $# -eq 1 ];then
  protoc $1 --java_out=../src/main/java
else
   echo "useage protoc <filename>"
fi
