#!/bin/sh
find . -name "*.class" | xargs rm
rm -rf sources.txt
rm -rf simulation.txt