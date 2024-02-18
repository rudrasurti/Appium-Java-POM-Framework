#!/bin/bash

# Define variables
api_token="" # Replace with your actual API token
owner_name=""
app_name=""
release=latest

if [ "$1" != "latest" ]; then
    if [[ $1 =~ \((.*?)\) ]]; then
        first_group_value="${BASH_REMATCH[1]}"
        release=$first_group_value
        echo "Version found: $release"
        response=$(curl -s -H "Content-Type: application/json" \
        -H "X-Api-Token: $api_token" \
        "https://api.appcenter.ms/v0.1/apps/$owner_name/$app_name/releases/")
        release=$(echo $response | jq -r ".[] | select(.version==\"$release\")" | jq -r '.id')
        echo "Release version found: $release"
    else
        echo "version provided in invalid format. Sample format: 'Version 2.0.99 (563)'"
        exit 1
    fi
fi

# Fetch the latest release information
response=$(curl -s -H "Content-Type: application/json" \
                 -H "X-Api-Token: $api_token" \
                 "https://api.appcenter.ms/v0.1/apps/$owner_name/$app_name/releases/$release")

download_url=$(echo $response | jq -r '.download_url')

# Check if download_url is valid
if [ -z "$download_url" ] || [ "$download_url" == "null" ]; then
    echo "Failed to get the download URL"
    exit 1
fi

echo $response
short_version=$(echo $response | jq -r '.short_version')
version=$(echo $response | jq -r '.version')
apk_name="app-qa_Version_$short_version"_"($version).apk"
echo $apk_name
curl -L -o "$apk_name" "$download_url"
mv $apk_name ./src/test/resources/app/$apk_name
ls -la ./src/test/resources/app/
echo "Download completed: $apk_name"

export apk_name=$apk_name