@ECHO OFF
CLS
SET PRO_ROOT=C:\Users\50414\Desktop\1111\cystrixblog
cd %PRO_ROOT%
mvn clean package -DskipTests
call :afterbuild
EXIT /B 0
:afterbuild
scp .\target\cystrixblog-1.0.0.jar root@127.0.0.1:/root/
ECHO 上传成功...
