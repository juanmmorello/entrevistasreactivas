#!/bin/sh
rm sources -rf
mkdir sources
cd sources

echo === Clonando ===

if [[ $# == 1 ]];then
    git clone --single-branch -b $1 git@github.com:juanmmorello/entrevistasreactivas.git
else
    git clone --single-branch -b master git@github.com:juanmmorello/entrevistasreactivas.git
fi

echo === Creando scripts de despliegue  ===
cd ..
rm start.sh remove.sh stop.sh docker-compose.yml
cp ./sources/entrevistasreactivas/docs/despliegue/{start.sh,remove.sh,stop.sh,docker-compose.yml} ./

chmod 755 remove.sh start.sh stop.sh remove-start.sh