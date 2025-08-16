# XPath example

This route demonstrates how to extract data from an XML file using an XPath expression in Camel. It reads employee data from an XML file and prints the name of the first employee to the terminal.

Start route with

```bash
camel run --dev xpath-test.camel.yaml
```

Open another terminal session to send test file data like this


```bash
camel cmd send xpath-test --body=file:employees.xml 
```

See name of the first employee printed on terminal output
