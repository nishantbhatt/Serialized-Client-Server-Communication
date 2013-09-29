Serialized-Client-Server-Communication
======================================

Distributed Systems

Question:

Write a Java client application that creates an instance of Couple and instantiates one Person. 
It then sends this serialized instance of Couple to a server. The server adds a second Person to Couple
and returns the value back to the client.  In order to validate your client / server application print 
out the values of Couple before sending it to the server, after the server received it, and when the 
client received the modified value of Couple from the server.

Answer:

We first execute the server code and wait for client to connect

![Alt text](http://s8.postimg.org/ernvb7djp/Picture1.png)

The compiled client code is then executed. The order in which client/server communicate is given below:
Client locally verifies that the attributed are correctly written to clients output stream for Person One 
before sending it off to the Server.

We then check on server that the Person One attributes are received correctly by server.

Once Person One attributes are received, Server writes Person Two to the servers output stream to be sent to 
client through the pipe. Below, we verify that server has locally created the correct attributes before sending
it off to the client.

Client verifies that the Person Two attributes added by the server are received correctly through the pipe from
the server.

Following values are printed upon executing client.
![Alt text](http://s16.postimg.org/o4kotjqo5/Server.png)

As noticed above, the server contains only person one attributes since person two attributes are not yet added.
Thus, we get a null pointer exception for person two.

Following output is received upon executing the code on client.
![Alt text](http://s8.postimg.org/ukjn06lp1/Client.png)

From above output, it is noticed that, Client, initially only contains person one attributes before connecting
to the server. Thus, when person two values are printed, we get a null pointer exception. Additionally, Once
the client receives the modified value of Couple from server, it contains both Person one's and Person two's information.

Please refer to the attached code and feel free to use it.
