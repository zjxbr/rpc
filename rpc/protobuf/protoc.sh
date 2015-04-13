#!/bin/bash
#需要在/etc/profile中设置自己的目录export SRC_DIR=/home/zjx/git
if [ $# -eq 1 ];then
  protoc $1 --java_out=../src/main/java
else
   echo "useage protoc <filename>"
fi
