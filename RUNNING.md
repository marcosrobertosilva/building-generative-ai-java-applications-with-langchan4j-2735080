# How to Compile and Run

This guide explains how to compile and run Java source files from this project.

## Prerequisites

- Java 17 or higher installed
- Gradle installed on your system (to generate the wrapper)

## Step 1: Generate the Gradle Wrapper (First Time Only)

If the `gradlew` file doesn't exist in the project root, you need to generate it first. This only needs to be done once.

Open a terminal in the project root directory and run:

```bash
gradle wrapper
```

This will create the following files:
- `gradlew` - The Gradle wrapper script for Linux/macOS
- `gradlew.bat` - The Gradle wrapper script for Windows
- `gradle/wrapper/gradle-wrapper.jar` - The wrapper JAR file
- `gradle/wrapper/gradle-wrapper.properties` - Wrapper configuration

> **Note:** You need Gradle installed on your system to run this command. After the wrapper is generated, you can use `./gradlew` without having Gradle installed.

## Step 2: Compile the Project

Compile all source files:

```bash
./gradlew build
```

## Step 3: Run a Specific Java Class

Run any class with a `main` method using:

```bash
./gradlew run -PmainClass=HelloWorldSystem
```

> **Note:** Replace `HelloWorldSystem` with the name of the class you want to run (e.g., `Chat`, `Translate`, `Summarizer`).

### Quiet Mode (Less Output)

For cleaner output without Gradle build messages:

```bash
./gradlew -q --console=plain run -PmainClass=HelloWorldSystem
```

## Available Classes to Run

| Class | Description |
|-------|-------------|
| `HelloLangChain4j` | Basic LangChain4j introduction |
| `HelloWorldSystem` | Hello World with system prompts |
| `Chat` | Chat functionality |
| `ChatContext` | Chat with context |
| `Collaboration` | Multi-agent collaboration |
| `Setup` | Initial setup example |
| `SimpleTemplate` | Template usage example |
| `Summarizer` | Text summarization |
| `SystemUserLoop` | System-user interaction loop |
| `Translate` | Translation functionality |

## Troubleshooting

If you encounter dependency issues, try:

```bash
./gradlew clean build --refresh-dependencies
```

## Environment Variables

Make sure to set your API keys as environment variables before running:

```bash
export OPENAI_API_KEY=your_key_here
export GOOGLE_AI_GEMINI_API_KEY=your_key_here
export ANTHROPIC_API_KEY=your_key_here
```
