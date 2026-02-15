# Deploy simple route to k8s

## Create route

```bash
camel init hello.camel.yaml
```

## Run route

```bash
camel run --dev hello.camel.yaml
```

## deploy route

```bash
camel kubernetes run hello.camel.yaml
```