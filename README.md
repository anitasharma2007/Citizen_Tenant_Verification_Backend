# Citizen Tenant Verification Backend

This repository contains the backend code for the Citizen Tenant Verification system. The system is designed to provide a streamlined process for verifying tenant information securely and efficiently.

## Features

- Tenant Information Management: Allows landlords or property managers to input and manage tenant information securely.
- Verification Process: Implements a verification process to authenticate tenant details such as identity, employment, and rental history.
- Integration with External Services: Connects with external services for verifying identity documents, employment status, and previous rental history.

## Technologies Used

### <ins>Framework: Spring Boot</ins>

- Spring Boot is an open-source Java-based framework used for building stand-alone, production-grade Spring-based applications with minimal setup. It provides a rapid development environment by leveraging the Spring ecosystem and convention-over-configuration principles.

**Example Use Cases within the Citizen Tenant Verification Application:**

- Building RESTful APIs for managing tenant information and verification processes.
- Developing backend services for handling authentication, authorization, and data management.
- Ensuring production-grade reliability and performance.

**Key Benefits for the Citizen Tenant Verification Backend:**

- Rapid development and deployment of server-side logic.
- Reduced overhead with minimal setup and configuration.
- Seamless integration with other components of the application stack.

### <ins>Database: SQL SERVER 2017</ins>

**Master Tables:**

Master tables typically store reference data that remains relatively static and is used to populate dropdown lists, provide lookup values, or maintain consistent values across the application. These tables often have primary keys that serve as unique identifiers for each record.

| Table Name  | Description |
| ------------- | ------------- |
| Nationality  | Stores names of different countries.  |
| State  | Contains name of states within each country.  |
| District  | Contains name of districts within each state.  |
| Police Station  | Contains name of police stations within each district.  |
| Occupation  | Stores names of different occupations.  |
| Gender  | Stores different gender types.  |
| Relation Type  | Stores different relation types.  |
| Document Type  | Stores different types of document for verification.  |

**Transaction Tables:**

Transaction tables store dynamic data that is frequently updated as part of regular operations within the application. These tables often have foreign keys to establish relationships with master tables and maintain data integrity.

| Table Name  | Description |
| ------------- | ------------- |
| Person Info  | Stores information of owner, tenant and family member.  |
| Person Address  | Contains address information of owner and tenant.  |
| Tenant Verification File  | Contains upload documents required for verification.  |

### <ins>REST APIs:</ins>

 - Attaching collection from postman to test the REST APIs for tenant verification application.
   
[Tenant Verification.postman_collection.json](https://github.com/anitasharma2007/Citizen_Tenant_Verification_Backend/files/15007058/Tenant.Verification.postman_collection.json)

