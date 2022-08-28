#!/bin/sh
find . -name "*.class" | xargs rm
rm -rf source.txt
rm -rf simulation.txt