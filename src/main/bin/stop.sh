#!/bin/bash

echo 'kill旧的服务---'

ps -ef | grep 'demo' |grep -v grep | awk '{print $2}' |xargs kill -9

echo 'kill旧的服务成功---'
