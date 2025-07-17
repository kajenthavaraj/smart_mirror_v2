# Smart Mirror

A Java Spring Boot web application that powers a smart mirror UI, displaying real-time time, date, and weather information.

## Features
- Displays current time and date
- Shows real-time weather information using the OpenWeatherMap API
- Responsive and accessible web UI
- Modular backend and frontend code structure

## Technology Stack
- Java 17
- Spring Boot 3
- Maven
- WebFlux (for HTTP client)
- HTML/CSS/JavaScript (static frontend)

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/kajenthavaraj/smart_mirror_v2.git
cd smart_mirror_v2
```

### 2. Configure the Weather API Key
Obtain an API key from [OpenWeatherMap](https://openweathermap.org/api).

Add your API key to `src/main/resources/application.properties`:
```
weather.api.key=YOUR_API_KEY_HERE
```

### 3. Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

The application will start on [http://localhost:8080/](http://localhost:8080/).

## Project Structure
```
smart_mirror_v2/
├── src/
│   ├── main/
│   │   ├── java/com/example/smartmirror/
│   │   │   ├── controller/
│   │   │   │   └── MirrorController.java
│   │   │   ├── model/
│   │   │   │   └── WeatherData.java
│   │   │   └── service/
│   │   │       └── WeatherService.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   └── styles.css
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Customization
- **Location:** To change the weather location, update the latitude and longitude in `WeatherService.java`.
- **UI:** Edit `src/main/resources/static/index.html` and `styles.css` for custom layouts and styles.

## Troubleshooting
- If weather info shows as `--°C` and `Error`, check your API key and ensure it is active and correct.
- Check backend logs for error messages.
- Ensure you have internet access for API calls.

## License
MIT License
