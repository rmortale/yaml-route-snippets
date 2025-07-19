# Howto pass configuration to camel-k integrations

## Example:

Create secret with all properties directly from `application.properties` file:

```bash
kubectl create secret generic app-props --from-file application.properties
```

then run the integration:

```bash
kamel run --dev --config secret:app-props app.camel.yaml
```