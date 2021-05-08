This project is separated into 3 parts and its main purpose is to serve as a system to regulate event authorization for a generic country during the COVID-19 pandemic.

Authorization is stipulated by the size of the event and the budget of the event promoter.

Part A of the project acts as a base for part B and C where main classes are defined such as:

Venue and it's children classes- Generates a venue based off certain specifications by the user in which an event can take place

Ministry-It exposes one public method, namely check approval(), which has the following behavior: int check approval(ApprovalRequest ar) assesses an approval request to see if an event should be held at a venue based on prevailing rules and returns the id of the approval request if it is determined that the event should be held.

Promoter-The Promoter class represents an event organizer who conceptualizes an event and initiates the process of getting it approved.

Approval Request-Generates an approval request and assigns a reference to an Event and a Venue. It then assigns a unique consecutively increasing id. The first id has a value of 0.

Date-The Date class used to represent a date in the system for a specific event

Approval Request- Creates an approval request which is used in the Ministry class.

PART B Part B is mainly structured around creating an interface for the project where the user has the ability to input their own data

PART C

Part C of the project was geared towards creating a GUI for the management of venues and promoters where the user had the ability to manipulate this data. This part of the project was done as a group with the two other contributors being Giovanne Pinto and Ikobi Lynch.
