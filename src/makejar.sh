
javac teamsassy/*.java
if [ "$?" -eq "0" ]; then
   jar cmvf META-INF/MANIFEST.MF Sassypoker.jar teamsassy/*.class teamsassy/images/*
fi
rm -rf teamsassy/*.class
