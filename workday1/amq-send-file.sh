#!/bin/bash

ACLI_DIR=/home/nino/Code/tools/a-cli

BROKER_URL=tcp://activemq:61617
BROKER_USER=admin
BROKER_PASSWORD=admin
HEADER=x-generatedBy=send-file.sh

BASEDIR=$(dirname "$0")

if [ "$#" -ne 3 ]; then
    echo "Usage: $0 <file> <count> <queue>"
    exit 1
fi

$ACLI_DIR/a -H $HEADER -b $BROKER_URL -U $BROKER_USER -P $BROKER_PASSWORD --put @$1 --count $2 $3


