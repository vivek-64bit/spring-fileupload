# Spring boot File upload and Validator 
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Launch](#launch)
* [Upload data format](#uploaddataformat)

## General info
This project is simple Spring boot application, which takes csv and xml file in a predefined format and validates for unique transaction keys
records.
Also validate end balance which should be equal to start balance +mutation.
In case validation fails it shows worng enteries to user.
	
## Technologies
Project is created with:
Spring boot
	
## Setup
You just need to clone it

## Launch
Launch it as java application using TransactionValidatorApplication.java

## Upload data format
It should be CSV or XML with below entries

Transaction reference
Account number
Start Balance
Mutation
Description
End Balance
