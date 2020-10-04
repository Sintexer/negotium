# Software requirements
### Contents
1. [Introduction](#1) <br>
  1.1. [Business requirements](#1.1) <br>
  1.2 [Analogues](#1.2) <br>
2. [Overall description](#2) <br>
  2.1. [Operating environment](#2.1) <br>
  2.2. [User classes and characteristics](#2.2) <br>
3. [External Interface Requirements](#3) <br>
  3.1. [Software interface](#3.1) <br>
  3.2. [User interface](#3.2) <br>
  3.3. [User roles](#3.3) <br>
4. [System features](#4) <br>
  4.1. [Functional requirements](#4.1) <br>
  4.2. [Non functional requirements](#4.2) <br>
     4.2.1. [Business rules](#4.2.1) <br>
     4.2.2. [Quality attributes](#4.2.2) <br>
	 4.2.3. [Quality attributes](#4.2.2) <br>

### 1. Introduction <a name="1"></a>

#### 1.1 Business requirements <a name="1.1"></a>
The purpose of web-service Negotium is to help provide people with job and provide companies with high-qualificated staff.
#### 1.2 Analogues <a name="1.2"></a>
* [LinkedIn](https://https://www.linkedin.com) American business and employment-oriented web-service.
* [Работа tut.by](https://jobs.tut.by)  Web-site for job search.

### 2. Overall description <a name="2"></a>

#### 2.1 Operating environment <a name="2.1"></a>
Application works in browser Google Chrome. Support of other browsers will be added in perspective.
#### 2.2 User classes and characteristics <a name="2.1"></a>
Users of web-service can be divided into 4 groups:
* employee
* employer
* admin
* non-authorized users

### 3. External Interface Requirements <a name="3"></a>

#### 3.1. Software interface <a name="3.1"></a>
1) [Spring Framework](https://spring.io/) Application framework and inversion of control contaimer for the Java platform
2) [PostgreSQL](https://www.postgresql.org/) Relational database management system for saving user's information.
3) [Thymeleaf](https://www.thymeleaf.org/) A template engine, that can process XML/XHTML/HTML5.
#### 3.2. User interface <a name="3.2"></a>
User interface is represented using mockups [authorization form](https://github.com/Pokemon3108/negotium/blob/master/documentation/mockup/authorization.pdf) and [resume with personal info form](https://github.com/Pokemon3108/negotium/blob/master/documentation/mockup/resume.pdf)
#### 3.3. Communication interface <a name="3.3"></a>
HTTP communication standart is used.

### 4. System features <a name="4"></a>

#### 3.1. Functional requirements <a name="4.1"></a>
Employees are provided with next posibilities:
* authorization
* input information about yourself (name, educations, professional skills, foreign language level, hobbies, job experience, desired position)
* view of suitable vacancies
* reply on vacancies 
* raise resume in the list of resumes (paid feature)

Employers are provided with next posibilities: 
* authorization
* view of employees
* open vacancies (paid feature)
* communication with suitable employee

Admin are provided with next posibilities:
* registrate new employee
* raise resume in the list of resumes , if employee paid on it

Non-authorized users can view published vacancies.

#### 4.2. Non functional requirements <a name="4.2"></a>

  ##### 4.2.1. Business rules <a name="4.2.1"></a>
Admin can make paid operations from 9 am to 8 pm. Employees can reply on vacancies around the clock.
  ##### 4.2.2 Quality attributes <a name="4.2.2"></a>
* Maximum productivity
* Fast answer on paid service