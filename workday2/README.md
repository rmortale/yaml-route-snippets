# Simple camel-k workday route test

## Run local
Define local properties in file local.properties.

```
camel run --properties=local.properties workday.yaml --dev 
```

## Run on k8s
Create configmap for mustache template like this:

```
kubectl create configmap my-template --from-file=soap.mustache
```

Define k8s properties in file devt.properties.

```
kamel run --property=file:devt.properties -d camel:base64 --config configmap:my-template workday.yaml --dev
```

