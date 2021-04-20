# HelloJPro

This project, is a hello-world for [jpro, which enables javafx in the web.](https://www.jpro.one/)

[Here you can see this program running.](https://demos.jpro.one/helloworld.html)

More about JPRO: 
 * Website: [jpro.one](https://www.jpro.one/)
 * Twitter: [@jpro_one](https://twitter.com/jpro_one)
 * Ticket System: [JPro-tickets](https://github.com/JPro-one/JPro-tickets)

# How to start #

## Web Browser ##

### Start jpro in foreground (development mode) ###

```
./gradlew jproRun
```


### Start jpro in background (server mode) ###

```
./gradlew jproRestart
```


### Open jpro app in Web Browser ###
```
http://localhost:8080/index.html
```

### Show all jpro apps in Browser ####
```
http://localhost:8080/test/default
```

### Open jpro app in fullscreen ####
```
http://localhost:8080/test/fullscreen/[app-name]
```


# Deployment:

### Step `1`. Prepare your server

To run jpro on linux, the server must be configured correctly.

Checkout the following chapters to configure your server correctly for jpro:

[DEPLOYING JPRO](https://www.jpro.one/?page=docs/current/2.6/DEPLOYING_JPRO)
 
[PREPARING LINUX FOR JPRO](https://www.jpro.one/?page=docs/current/2.7/PREPARING_LINUX_FOR_JPRO)

### Step `2`. Create the binary

Create a zip which contains the application with the following command:

```groovy
./gradlew jproRelease
```
The path of the zip-file is the following: `build/distributions/HelloJPro-jpro.zip`

Now copy this file to your Server and unzip it.

### Step `3`. Run jpro

In the unzipped folder you can find a start-script: `bin/start.sh`

By running `./bin/start.sh` you start the JPRO Server on your server. 

The JPRO Server is now ready to server your URLs entered in your browser.

```bash
./bin/start.sh
```


