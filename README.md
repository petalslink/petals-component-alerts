# OW2 Petals Alert Component

This is a basic component to test alerts/defects provided by the Petals Component Development Kit (CDK).
It uses the Component API to register its Monitoring MBean to the JMX container provided by the Petals Kernel.
The component does not process any incoming nor JBI message but just expose a simple servlet which, once called, will send a defect. The defect will be catched by the monitoring layer and then sent to monitoring subscribers (using JMX channel).

## Usage

1. Compile the component or download it from the OW2 Maven repository
2. Install the component (drop it to the install folder is the easiest way to install)
3. HTTP GET http://localhost:8812

```
curl http://localhost:8812
```

--
@chamerling
