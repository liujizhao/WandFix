cd ./app/build/intermediates/classes/debug/
jar cvf hotfix_pack.jar ./com/example/motordex/AppParsenterImpl.class
dx --dex --output=../../../../../hotfix_pack.dex hotfix_pack.jar
