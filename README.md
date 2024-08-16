# Credit Simulator 

## Features

- Count monthly installments for vehicle loans.
- Able to load input data from a CSV file.

## What to install first

- **Java 11** or higher  installed on your machine.
- **CSV FILE** availabe in project, edit and run.
- **Docker** (optional): If you prefer running the application in a Docker container or you dont have java in your OS.

## How to Run the Application

### 1. Running the Application FROM IDE

#### Step 1: Clone the Repository

First, clone the repository to your local machine:

```bash
git clone <repository-url>
cd credit-simulator 
```
#### Step 2: Open with your favorite IDE

Run it, with program argument or not. for example If your CSV file in C/file.csv. Use formal like this in program argument C:\\file.csv


### 2. Running the Application with jar

#### Step 1: Clone the Repository

First, clone the repository to your local machine:

```bash
git clone <repository-url>
cd credit-simulator 
```
#### Step 2: Generate the jar file, or i provide it in the project. 

```bash
java -jar credit-simulator.jar {fileName}.csv  // if you want to run it with input file
java -jar credit-simulator.jar  // if you want to run it with user input
```

### 3. Running the Application with docker

#### Step 1: Clone the Repository

First, clone the repository to your local machine:

```bash
git clone <repository-url>
cd credit-simulator 
```
#### Step 2: Generate the jar file, or i provide it in the project.

#### Step 3: Run the command to build image.

```bash
docker build -t credit-simulator .
```

#### Step 4: Run the command to run the image.
```bash
docker run -it --rm credit-simulator // if you want to run it with user input
docker run -it --rm -v {fileLocation:/path/to/your/file.csv}:/app/{file.csv} credit-simulator /app/{file.csv}
 // if you want to run it with input file
 // for example is fileLocation is D:/CredSim.csv, so the full command will be
 // credit-simulator>docker run -it --rm -v D:\CredSim.csv:/app/CredSim.csv credit-simulator /app/CredSim.csv
```