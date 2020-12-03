echo 'kill旧的服务---'

ps -ef | grep 'demo' |grep -v grep | awk '{print $2}' |xargs kill -9

echo 'kill旧的服务成功---'

nohup java -jar -server -XX:+UseG1GC ../lib/demo.jar  &

echo  '重启新的的服务成功---'
