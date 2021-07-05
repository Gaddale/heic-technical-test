## Heic Technical Test

### Pre-requisites:

* Clone the repo
* On the root folder of the repo run these commands `mvn clean` and `mvn compile`

### Tools used

* Selenid with Java, Cucumber and Junit
* Cucumber html for reporting
* Browserstack

### Default settings

* Default browser is set to `safari`
* Default os is set to `os_x`  
* Default url is set to `https://test.app.upet.co/`
* Default environment is set to `remote`

### Execution in Browserstack environment

* Run against browser=chrome, os=mac os x `mvn verify -Dbrowser='chrome' -Dos='os_x' -Denv='remote'`
* Run against browser=safari, os=mac os x `mvn verify -Dbrowser='safari' -Dos='os_x' -Denv='remote'`
* Run against browser=firefox, os=mac os x `mvn verify -Dbrowser='firefox' -Dos='os_x' -Denv='remote'`
* Run against browser=firefox, os=windows `mvn verify -Dbrowser='firefox' -Dos='windows' -Denv='remote'`
* Run against browser=chrome, os=windows `mvn verify -Dbrowser='chrome' -Dos='windows' -Denv='remote'`

### Execution in local environment 

* Run against browser=chrome, env=local & os=windows `mvn verify -Dbrowser='chrome' -Dos='windows' -Denv='local` 
* Run against browser=firefox, env=local & os=windows `mvn verify -Dbrowser='firefox' -Dos='windows' -Denv='local`
* Run against browser=chrome, env=local & os=linux `mvn verify -Dbrowser='chrome' -Dos='linux' -Denv='local`
* Run against browser=firefox, env=local & os=linux `mvn verify -Dbrowser='firefox' -Dos='linux' -Denv='local`

### Reporting

* Cucumber html reports `target/cucumber-html-reports/overview-features.html`
