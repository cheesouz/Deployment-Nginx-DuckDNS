## Infrastructure 3 Project
### Lucy Poplawska ACS202

## Run instructions
### 1. SSL Certificate Generation
First, run the certbot container to obtain the SSL certificate. Using **--env-file ../.env** is crucial, 
otherwise this container cannot properly!!

```shell
cd generate_ssl
docker compose --env-file ../.env up
```

Wait for the container to successfully exit. This indicates that the certificates have been generated.

### 2. Start the Main Application
After the certificate generation is complete, run the main application:

```shell
cd ..
docker compose up
```

### 3. Accessing the Applications
Once the containers are running, you can access:

- Spring Boot application: https://lpoplawska.duckdns.org/app1/
- Static website: https://lpoplawska.duckdns.org/app2/

---

## Project Structure
- `/nginx`: Contains Nginx reverse proxy configuration
- `/springboot-app`: Spring Boot application with PostgreSQL database connection
- `/static-site`: Static website files
- `/generate_ssl`: Certbot configuration for SSL certificate generation
- `/certs`: Directory where SSL certificates are stored


## Architecture
- **Nginx Reverse Proxy**: Routes traffic to appropriate services based on URL paths
- **Spring Boot Application**: Java backend application with PostgreSQL database
- **Static Website**: Served through Nginx
- **SSL Certificate Management**: Using Certbot with DuckDNS plugin
- **Database**: PostgreSQL for data persistence
