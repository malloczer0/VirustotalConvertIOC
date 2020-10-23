# VirustotalConvertIOC

Console application that will convert IOCs (Indicator of compromise) from MD5 or SHA-1 to SHA256.

## ConvertIOC

Main object with `@Jvmstatic` `main` function only. Loads API key from source file and checks program arguments. Runs `VirustotalAPI`.

## VirustotalAPI

An open class that retrieve file scan reports. 

For details: https://developers.virustotal.com/reference#getting-started

`getFileScanReports(apiKey, resource, output)` retrieves file scan reports actually. Requires `apiKey` - API key actually `resource` - resource(s) to be retrieved 
and `out`  - for output manage.

For details: https://developers.virustotal.com/reference#file-report 

## JsonParser

Open class that has a parse method `toHashmap(json: String)` from `*.json` `String` to `Map<String, Any>`.

## JsonPerformance

Open class with an only `handleMapping(json: Map<String, Any>)` method to a required different format from `Technical requirement`. 

## Output

A layer of abstraction between the actual logic and working with output. 
Makes possible to replace `STDOUT` (output) with other data consumers realizing a `write(str)` method.

## StdOutput

A default realization of an `Output` interface in `VirustotalAPI` that prints data right to the `STDOUT`
