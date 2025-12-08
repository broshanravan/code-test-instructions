# Implementation and use
The code is implemented in two parts.
The front end is developed using Nodejs and backend used Java 20.
For data persistence a NoSQL MongoDB data storage has been previsioned. However, in order to keep the data saves even after the application is stops,
instead of using an in memory Database a NoSQL DB has been provisioned on MongoDB Atlas on the following address
This would allow the records to be added into the DB in shape of URL objects rather than Strings.
In case you need to inspect the data, the username and password are in the properties file of the java application.

NodeJs server is running on port 3500 and entry point for the page that used for maintaining the data would is

http://host:port/ /url_customization
upon changing submitting the data the NodeJs application will call APIs on the java app and checks if the record exists 
before attempting to add a new one, displaying or deleting it


There are still a few tidy up that needs to be done and most of unit tests are not ready to be pushed.
In case The time could be extended by another 48 hours the rest can be done.

# URL Shortener Coding Task

## Task

Build a simple **URL shortener** in a ** preferably JVM-based language** (e.g. Java, Kotlin).

It should:

- Accept a full URL and return a shortened URL.
- Persist the shortened URLs across restarts.
- Allow a user to **customise the shortened URL** (e.g. user provides `my-custom-alias` instead of a random string).
- Expose a **decoupled web frontend** built with a modern framework (e.g., React, Next.js, Vue.js, Angular, Flask with templates). This can be lightweight form/output just to demonstrate interaction with the API. Feel free to use UI frameworks like Bootstrap, Material-UI, Tailwind CSS, GOV.UK design system, etc. to speed up development.
- Expose a **RESTful API** to perform create/read/delete operations on URLs.  
  → Refer to the provided [`openapi.yaml`](./openapi.yaml) for API structure and expected behaviour.
- Include the ability to **delete a shortened URL** via the API.
- **Have tests**.
- Be containerised (e.g. Docker).
- Include instructions for running locally.

## Rules

- Fork the repository and work in your fork. Do not push directly to the main repository.
- We suggest spending no longer than **6-8 hours**, but you can take longer if needed.
- **Commit often with meaningful messages.**
- Write tests.
- Use the provided [`openapi.yaml`](./openapi.yaml) as a reference.
- Focus on clean, maintainable code.
- AI tools (e.g., GitHub Copilot, ChatGPT) are allowed, but please **do not** copy-paste large chunks of code. Use them as assistants, not as a replacement for your own work. We will be asking.

## Deliverables

- Working code.
- Decoupled web frontend (using a modern framework like React, Next.js, Vue.js, Angular, or Flask with templates).
- RESTful API matching the OpenAPI spec.
- Tests.
- A git commit history that shows your thought process.
- Dockerfile.
- README with:
  - How to build and run locally.
  - Example usage (frontend and API).
  - Any notes or assumptions.
