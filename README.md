
🍎 Grocery Fruits App (Android)

An Android application that communicates with a remote server and displays fruit information retrieved in JSON format.
The app is built as part of COMP4107 – In Class Study 4 (Spring 2025).

⸻

🌐 Server

Data Source:

https://berkeozenc.pythonanywhere.com/grocery/

	•	Returns fruit information in JSON format.
	•	Each fruit contains details such as name, origin, photo, and vitamin content.

⸻

📱 Application Structure

The app consists of 3 Activities:

1. Main Activity
	•	A “List All” button → navigates to Listing Activity.
	•	A Textbox + Search button → searches for a fruit by name and navigates to Details Activity.
	•	Design must remain as specified in the assignment.

2. Listing Activity
	•	Displays a list of all fruits retrieved from the server.
	•	Each item shows:
	•	Fruit photo
	•	Fruit name
	•	Origin
	•	Clickable list items → selecting an item opens Details Activity.
	•	Layout must match the provided design.

3. Details Activity
	•	Shows detailed fruit information based on the selected fruit or search result.
	•	Data may vary per fruit (e.g., some fruits list Vitamin C and K, others list different nutrients).
	•	Layout follows the given design, but displayed attributes adapt dynamically to the JSON response.

⸻

⚙️ Tech Stack
	•	Language: Java / Kotlin (Android)
	•	Framework: Android SDK
	•	Networking: HttpURLConnection / OkHttp / Retrofit (developer’s choice)
	•	JSON Parsing: org.json / Gson / Moshi
	•	UI Components: RecyclerView, ImageView, TextView, EditText, Buttons

⸻

🚀 Running the Project
	1.	Clone the repository.
	2.	Open in Android Studio.
	3.	Run on emulator or physical device (min SDK 24+ recommended).

⸻

✅ Features
	•	🔎 Search fruits by name
	•	📋 List all fruits with image, name, and origin
	•	📖 View detailed information dynamically from JSON
	•	📱 Three well-structured Activities with clean navigation

⸻

📜 Notes
	•	Create a new Android project → do not modify an existing example.
	•	Follow the given UI design layouts strictly.
	•	Ensure robustness in case the JSON data differs across fruits.

⸻
