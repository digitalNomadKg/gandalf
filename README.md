# 📌 Adcash WebApp Deployment with Prometheus Monitoring

This project demonstrates deploying a Spring Boot web application to an AWS EKS cluster, exposing custom metrics, and monitoring them with Prometheus installed on an EC2 instance. 

All infrastructure is configured using best practices, including static IP access and Ansible-based provisioning.

 ---
## 📝 Project Requirements

Deploy a web app in any language.

App should serve:
 - /gandalf: show Gandalf's picture
 - /colombo: show current time in Colombo (Sri Lanka)

Expose metrics for:
 - Total requests to /gandalf
 - Total requests to /colombo

Run on a static IP.

Only port 80 should be open.

Deploy Prometheus on a separate VM using Ansible.

 ## 📚 Technologies Used

| Technology                | Purpose                                                    |
|:--------------------------|:-----------------------------------------------------------|
| Java / Spring Boot        | for developing the web application                         |
| Micrometer + Prometheus   | for custom metric collection and exposure                  |
| Docker                    | for containerizing the application                         |
| AWS EC2                   | used to host Prometheus monitoring service                 |
| AWS EKS                   | managed Kubernetes service for scalable deployment         |
| Ansible                   | for automated provisioning and configuration of Prometheus |
| eksctl                    | for managing EKS cluster setup                             |
| kubectl                   | for managing Kubernetes resources                          |

---

## 🚀 How to Access the Application

✅ Currently application is up and running and available at: 

🔍 Test Endpoints
```bash
curl http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/gandalf
curl http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/colombo
curl http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/actuator/prometheus | grep requests_total
```
Or open directly in the browser:

👤 Displays Gandalf's image:

```bash
http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/gandalf
```

📄 Displays current time in Colombo, Sri Lanka:

```bash
http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/colombo
```
🌍 Prometheus-formatted metrics endpoint:

```bash
http://a20060d09589b496291d9feca5ad5e74-3dc4e3db68b18dc1.elb.eu-west-1.amazonaws.com/actuator/prometheus
```

🌐 Prometheus UI (running on EC2 VM) is accessible via:
```bash
http://18.202.16.234:9090/targets
```

------

## ⚙️ Setup Instructions

### 🧰 Clone the image or repository

🐳 Docker Image

```bash
docker pull drcemae/demo-adcash.webapp:0.0.4
```
🔗 Github repository

```bash
git clone https://github.com/digitalNomadKg/gandalf.git
```
or via SSH

```bash
git clone git@github.com:digitalNomadKg/gandalf.git
```
---
### 🖥️  Run and test locally

🐳 Using Docker

```bash
docker run -p 8080:8080 drcemae/demo-adcash.webapp:0.0.4
```
🔗 Using Maven

```bash
cd demo
mvn clean package
mvn spring-boot:run
```
🔍 Test Endpoints

```bash
curl "http://localhost:8080/gandalf"
curl "http://localhost:8080/colombo"
curl http://localhost:8080/actuator/prometheus | grep requests_total
```
Or open directly in the browser:

* http://localhost:8080/colombo

* http://localhost:8080/gandalf

* http://localhost:8080/actuator/prometheus 

---

## 💡 Future Improvements
- ✅ Integrate CI/CD pipeline (e.g., GitHub Actions or GitLab CI) for automated builds and deployments
- ✅ Read more about and implement LoadBalancer with AWS ALB Ingress Controller for better flexibility
- ✅ Set up a custom domain for the EKS Load Balancer
- ✅ Add Grafana dashboard
- ✅ Use Terraform for infrastructure

## 🧠 Decisions & Design Choices

1. 🧱 Spring Boot + Micrometer

I chose Spring Boot because it offers fast development with production-ready features out of the box + I was practicing it before.  Micrometer integrates seamlessly with Spring to expose Prometheus-compatible metrics via /actuator/prometheus.

2. 🐳 Dockerized Web App

Containerizing the application with Docker ensures consistent builds and portability. It allows the same image to be used for local testing and Kubernetes deployment.

3. ☁️ AWS EKS for Deployment

AWS EKS was chosen as the Kubernetes platform for its scalability and ease of integration with other AWS services. It abstracts away control plane management, letting me focus on application-level concerns.

4. ⚖️ LoadBalancer Service Type

To satisfy the “static IP” and “port 80 only” requirements, I used a LoadBalancer service in Kubernetes, which provisions an AWS ELB and exposes it via HTTP on port 80.

5. 📊 EC2-hosted Prometheus

Prometheus was deployed to a dedicated EC2 instance using Ansible for automation. This reflects a real-world monitoring setup where metrics collection is handled independently of the application infrastructure.

6. ⚙️ Ansible for Provisioning

I used Ansible to ensure Prometheus setup is reproducible and declarative. This also separates concerns between infrastructure automation and application logic.

7. 📈 Exposed Metrics

The application exports two metrics:

- Total requests to /gandalf
- Total requests to /colombo

This provides insight into endpoint usage, fulfilling the project’s observability requirements.

## 👤 Author
Timur B.

---

## 📄 License
MIT

---