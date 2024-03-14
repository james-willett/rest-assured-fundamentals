#!/usr/bin/env bash

set -e # exit immediately after any error

echo -e "\n- Installing buildx."
export BUILDX_VERSION=v0.13.1
curl -JLO "https://github.com/docker/buildx/releases/download/$BUILDX_VERSION/buildx-$BUILDX_VERSION.linux-amd64"
mkdir -p ~/.docker/cli-plugins
mv "buildx-$BUILDX_VERSION.linux-amd64" ~/.docker/cli-plugins/docker-buildx
chmod +x ~/.docker/cli-plugins/docker-buildx
docker login -u concur-devfabric docker-hub.common.repositories.cloud.sap --password=$SAP_ARTIFACTORY_IDENTITY_TOKEN
docker run --privileged --rm docker-hub.common.repositories.cloud.sap/tonistiigi/binfmt --install arm64
docker buildx create --use --name multiarch