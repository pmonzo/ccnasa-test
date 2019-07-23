# Back End Exam 2

The NASA wants to shoot yet another rocket to the orbit. As this is your first day as a wannabe scientist at the ground control, you are very excited. So excited that when the guy responsible for the countdown asks you to bring him some coffee, you accidentally spill it all over his lap and the computer – both are not capable of doing their job now.

But the liftoff is only seconds away. Somebody has to do the countdown – or the rocket can’t start and millions of dollars are lost! In a moment of great bravery, you remember you learnt how to count (a long time ago in High School). So, you take the chance!

The ground control chief wants you to set up on configuration of the application the initial number of seconds where to start – then count to 0. So once the application starts, the countdown begins and you are requested to implement a service with a method that returns the seconds remaining to reach 0. This service could be implemented as a webservice (restful) or as a WebAPI.


## Solution

I have implemented a rest versioned webservice in which you can check the countdown to launch. This service is hosted in:

http://localhost:8080/api/v1/countdown

and returns a Json with the countdown.

```json
{
"remainingTime": "34.083"
}
```

### Technologies

#### Spring Webflux

A framework for rest webservices using Streams

#### Logging

For logging this application uses log4j2.

#### Micrometer

A framework for taking metrics without impact on application performance. Also has a plugin to expose this metrics to Prometheus.

#### Docker

There is a Dockerfile with the configuration for executing this application in a Docker container.

#### Apache Jmeter

To take performance data I used Jmeter. Added a project for Jmeter performance_test.jmx.