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

👤 Displays Gandalf's image:

```bash
http://a3b812cc2db824031ab67dcb175eb5a9-a968637e6cd5b65c.elb.us-east-1.amazonaws.com/gandalf
```

📄 Displays current time in Colombo, Sri Lanka:

```bash
http://a3b812cc2db824031ab67dcb175eb5a9-a968637e6cd5b65c.elb.us-east-1.amazonaws.com/colombo
```
🌍 Prometheus-formatted metrics endpoint:

```bash
http://a3b812cc2db824031ab67dcb175eb5a9-a968637e6cd5b65c.elb.us-east-1.amazonaws.com/actuator/prometheus
```

🌐 Prometheus UI (running on EC2 VM) is accessible via:
```bash
http://98.82.247.61:9090/targets
```

------

## ⚙️ Setup Instructions

### 🧰 Clone the image or repository

🐳 Docker Image

```bash
docker pull drcemae/demo-adcash.webapp:0.0.4
```
🔗 Github remote repository

```bash
git clone https://github.com/digitalNomadKg/gandalf.git
```
```bash
git clone git@github.com:digitalNomadKg/gandalf.git
```
---
### 🖥️  Run and test locally

🐳 Docker Image

```bash
docker run -p 8080:8080 drcemae/demo-adcash.webapp:0.0.4
```
🔗 Github remote repository

```bash
cd demo
```
```bash
mvn clean package
```
```bash
mvn spring-boot:run
```
```bash
curl -X GET "http://localhost:8080/gandalf"
```
```bash
curl -X GET "http://localhost:8080/colombo"
```
```bash
curl http://localhost:8080/actuator/prometheus | grep requests_total
```
```bash
http://localhost:8080/colombo
```
```bash
http://localhost:8080/gandalf
```
```bash
http://localhost:8080/actuator/prometheus 
```

