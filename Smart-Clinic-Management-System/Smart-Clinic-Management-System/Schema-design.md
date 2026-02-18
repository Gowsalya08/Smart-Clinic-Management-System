# Schema Design - Smart Clinic Management System

## Entities

### 1. Doctor
Represents a medical professional.
- **id**: Long (Primary Key, Auto Increment)
- **name**: String
- **specialization**: String
- **email**: String (Unique)
- **password**: String (Hashed - for simulation purposes, maybe plain if very simple)

### 2. Patient
Represents a patient visiting the clinic.
- **id**: Long (Primary Key, Auto Increment)
- **name**: String
- **email**: String (Unique)
- **phone**: String

### 3. Appointment
Represents a scheduled meeting between a patient and a doctor.
- **id**: Long (Primary Key, Auto Increment)
- **doctorId**: Long (Foreign Key -> Doctor)
- **patientId**: Long (Foreign Key -> Patient)
- **dateTime**: LocalDateTime
- **status**: Enum (SCHEDULED, COMPLETED, CANCELLED)

### 4. Prescription
Represents medication prescribed after an appointment.
- **id**: Long (Primary Key, Auto Increment)
- **appointmentId**: Long (Foreign Key -> Appointment)
- **medication**: String
- **dosage**: String
- **instructions**: String

## Relationships
- **Doctor** 1:N **Appointment**
- **Patient** 1:N **Appointment**
- **Appointment** 1:1 **Prescription**
