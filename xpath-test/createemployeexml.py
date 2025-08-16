import xml.etree.ElementTree as ET

NAMESPACE = "http://example.com/employees"
PREFIX = "emp"

ET.register_namespace(PREFIX, NAMESPACE)

root = ET.Element(f"{{{NAMESPACE}}}employees")

for i in range(1, 10001):
    emp = ET.SubElement(root, f"{{{NAMESPACE}}}employee")
    ET.SubElement(emp, "id").text = str(i)
    ET.SubElement(emp, "name").text = f"Employee {i}"
    ET.SubElement(emp, "department").text = f"Department {(i % 10) + 1}"
    ET.SubElement(emp, "email").text = f"employee{i}@example.com"

tree = ET.ElementTree(root)
tree.write("employees.xml", encoding="utf-8", xml_declaration=True)