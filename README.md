📂 CSV & JSON Address Manager (Java)

A small Java desktop app using JOptionPane to manage an address list, supporting CSV and JSON formats.


🚀 Features

• Read and display address list from CSV
• Add new addresses
• Export all entries to JSON
• Import addresses from a JSON file
• Basic input validation
• Simple GUI built with JOptionPane

🧰 Technologies

Language: Java (SE 17+)
GUI: Swing (JOptionPane)
JSON Handling: Gson (https://github.com/google/gson)


🧱 Project Structure

src/
 └─ main/
    └─ java/
       └─ de/
          └─ wayrier/
             └─ adressmanager/
                ├─ CSVApp.java
                ├─ CSVManager.java
                ├─ CSVEntry.java
                ├─ CSV_JSON_APP.java
                └─ JsonDemo.java
data/
 ├─ csv.csv
 └─ personen.json


▶️ How to Run

1. Open the project in IntelliJ IDEA
2. Make sure gson-2.11.0.jar is added to your project libraries
3. Run the main class:
   CSVApp.java
4. Follow the pop-up prompts to manage addresses.


🧠 Learning Outcome

This project demonstrates:
• Java file handling (CSV / JSON)
• Basic GUI programming with Swing
• Exception handling & user validation
• Modular class design (MVC-like separation)

📄 License

MIT License © 2025 Mohammed Afana (Wayrier)
GitHub: https://github.com/Wayrier/java-csv-json-address-manager
