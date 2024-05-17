# URL Shortener

## Description
This project is a URL Shortener service built using React for the frontend and Java Spring Boot with JDK 17 for the backend. It utilizes Redis for storing shortened URLs. You can run the Redis in WSL mode.

## Features
- Shorten long URLs into concise, shareable links.
- Redirect users from shortened links to original URLs seamlessly.
- Simple and intuitive user interface built with React.
- Efficient backend powered by Java Spring Boot.
- Redis integration for fast and reliable URL storage and retrieval.
- URL expiry configurable
- If not configured by default it's set for 60 seconds post which URL will be automatically destroyed (default value can be configured for higher interval)
## Setup Instructions
### Prerequisites
- WSL (Windows Subsystem for Linux) for Redis server
- Node.js
- JDK 17

### Installation
1. Clone this repository to your local machine.
   ```bash
   git clone [https://github.com/your-username/url-shortener.git](https://github.com/chinmay-sawant/URLShortener)

2. Navigate to the frontend directory and install dependencies.
   ```bash
   cd url-shortener/frontend
   npm install
