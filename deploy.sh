rm -rf ./dist/evolutions.report-1.0-SNAPSHOT
play dist
cd dist
unzip evolutions.report-1.0-SNAPSHOT.zip
scp evolutions.report-1.0-SNAPSHOT/lib/evolutions.report_2.9.1-1.0-SNAPSHOT.jar root@59.151.12.180:/root
