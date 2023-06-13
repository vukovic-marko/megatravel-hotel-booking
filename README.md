# Megatravel: A Distributed Hotel Booking Web Application

Welcome to the GitHub repository for Megatravel, a distributed hotel booking web application. This project aims to provide users with a seamless and efficient hotel booking experience through its advanced distributed architecture and feature-rich functionalities.

## Features

- Comprehensive search functionality for hotels based on location, price range, amenities, and ratings.
- Real-time updates for availability and pricing information.
- Reservation management system for booking, modification, and cancellation of hotel reservations.
- Hotel rating system for users to provide feedback and reviews.

## Architecture

![Architecture](https://github.com/vukovic-marko/megatravel-hotel-booking/blob/master/architecture.png)

The architecture of Megatravel is designed as a distributed system to ensure scalability, maintainability, and flexibility. It comprises the following components:

- Monolithic Backend Agent Application: A robust web application that provides advanced logic for efficient hotel bookings. Built with Spring Boot and Java.
- Microservice-based Main Backend Application: Follows a microservice architecture and handles routing using Zuul. Communicates with frontend applications and the backend agent application. Developed using Spring Boot and Java.
- SOAP and REST APIs: Backend agent application and main backend application communicate via SOAP for secure and reliable data exchange. Frontend applications interact with backend applications through RESTful APIs.
- Cloud Function and Cloud API Integration: Integration with a cloud function hosted on the Google Cloud Platform enables real-time hotel ratings and leverages Cloud API for seamless communication.

## Getting Started

To get started with Megatravel, follow these steps:

1. Clone the repository: `git clone https://github.com/vukovic-marko/megatravel-hotel-booking.git`
2. Install the necessary dependencies for backend applications.
3. Build and run the backend agent application and main backend application.
4. Launch the frontend applications in your preferred web browser.
