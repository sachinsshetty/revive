* to find ipadress of webapp, execute below command in terminal(WIP to convert to shell script)
  * docker ps > ps.out
  * grep -i "avti-app:latest" ps.out | cut -d " " -f 1
  * ipaddress=$(cat container.out)
  * docker inspect $ipaddress > inspect.out
  * grep -i "ipaddress" inspect.out