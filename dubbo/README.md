ǰ��֪ʶ
1.������һͨ��ջ����Ҫ����
```
/**
������õ���ʵ�ֶ�ӦЭ���װ����  Ҫ��װ�����Ĺ��췽������Ϊ��װ�Ķ�Ӧ�ӿڣ�����д����Ӧ�ӿڵ�META-INFĿ¼�£�����ʵ��װ���߱��������
*/
cacheWrapperClass:808, ExtensionLoader (org.apache.dubbo.common.extension)
loadClass:726, ExtensionLoader (org.apache.dubbo.common.extension)
loadResource:702, ExtensionLoader (org.apache.dubbo.common.extension)
loadDirectory:674, ExtensionLoader (org.apache.dubbo.common.extension)
loadExtensionClasses:636, ExtensionLoader (org.apache.dubbo.common.extension)
getExtensionClasses:619, ExtensionLoader (org.apache.dubbo.common.extension)
createExtension:521, ExtensionLoader (org.apache.dubbo.common.extension)
getExtension:347, ExtensionLoader (org.apache.dubbo.common.extension)
main:14, TestDubbo (com.self.entertainment.unclassified)
```
2. ��ҪŪ���protocolistenerWrapper��ԭ��
��ʵ����װ����ģʽ����װ��Ȼ�����һ��������ʱ��ͻ�ȥ���������Ķ���ͻ���⼸��wrapper��ִ����

3.����Э������ƴ�����Ĵ���ִ�����Ӧ��Factory    //��Ҫ����һ��extensionLoader��Դ����
```
package org.apache.dubbo.registry;
import org.apache.dubbo.common.extension.ExtensionLoader;
public class RegistryFactory$Adaptive implements org.apache.dubbo.registry.RegistryFactory {
public org.apache.dubbo.registry.Registry getRegistry(org.apache.dubbo.common.URL arg0)  {
if (arg0 == null) throw new IllegalArgumentException("url == null");
org.apache.dubbo.common.URL url = arg0;
String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() );
if(extName == null) throw new IllegalStateException("Failed to get extension (org.apache.dubbo.registry.RegistryFactory) name from url (" + url.toString() + ") use keys([protocol])");
org.apache.dubbo.registry.RegistryFactory extension = (org.apache.dubbo.registry.RegistryFactory)ExtensionLoader.getExtensionLoader(org.apache.dubbo.registry.RegistryFactory.class).getExtension(extName);
return extension.getRegistry(arg0);
}
}
```
4.��������������ʱ�����Լ�Ҳע�ᵽ��������������Ӧ�ڵ��µ�������  ����
```
register:41, SimpleRegistryService (com.self.entertainment.config)
register:44, AbstractRegistryService (com.self.entertainment.config)
//�������ע������ע���Լ��ķ���
doRefer:383, RegistryProtocol (org.apache.dubbo.registry.integration)
refer:367, RegistryProtocol (org.apache.dubbo.registry.integration)
//��װ����ģʽ��װ�Ĺ�������������ִ�е�������refer����֮ǰ����⼸�����refer�������ᱻִ��
refer:70, QosProtocolWrapper (org.apache.dubbo.qos.protocol)
refer:114, ProtocolFilterWrapper (org.apache.dubbo.rpc.protocol)
refer:65, ProtocolListenerWrapper (org.apache.dubbo.rpc.protocol)
refer:82, CustomProtocolListenerWrapper (com.self.entertainment.common)
refer:65, ProtocolListenerWrapper (org.apache.dubbo.rpc.protocol)
refer:-1, Protocol$Adaptive (org.apache.dubbo.rpc)
//��������url��ͷЭ��ȡ�����Ӧ��ʵ�ּ�RegistryProtocol ��Ϊÿ�������߽��з�װ����
createProxy:366, ReferenceConfig (org.apache.dubbo.config)
init:305, ReferenceConfig (org.apache.dubbo.config)
get:231, ReferenceConfig (org.apache.dubbo.config)
getObject:71, ReferenceBean (org.apache.dubbo.config.spring)
```
5.����䷢����һ��apache timer��ʵ����HashedWheelTimer��������һ��ʧ�ܹ��󲻶ϳ�����ĳ������Ĺ���
6.regidtryprotocol refer ����һ��RegistryDirectory�������ĵ�url��RegistryDirectory�ڲ�ת����Invoker
7.ReferenceBean�ڱ�������ʱ������ʵ����factorybean�����get()�����ߵ��������
```
getProxy:66, StubProxyFactoryWrapper (org.apache.dubbo.rpc.proxy.wrapper)
getProxy:-1, ProxyFactory$Adaptive (org.apache.dubbo.rpc)
createProxy:405, ReferenceConfig (org.apache.dubbo.config)
init:305, ReferenceConfig (org.apache.dubbo.config)
get:231, ReferenceConfig (org.apache.dubbo.config)
```
����һ������������ӵ�url��ʹ��JavassistProxyFactory����һ������Ϊʵ���Ľӿڽ��д���
```
invoker :interface com.self.entertainment.TestRestEasyService -> 
simple://127.0.0.1:8073/server@justTest?application=demo-
consumer&check=false&default.lazy=false&default.sticky=false&dubbo=2.0.2&interface=server@justTest&
lazy=false&methods=echo&pid=14932&register.ip=169.254.56.35&release=2.7.1&side=consumer&sticky=
false&timestamp=1562324452404,directory: 
org.apache.dubbo.registry.integration.RegistryDirectory@430afce5
```
8.���õ�ʱ���ٽ������ͷ�������RpcInvocation Զ�̵��ô���ͬ���ᵽMockClusterInvoker�������invoke�������ȥΪ���ɵ����RpcInvocationѡ��һ��������url����Զ�̵���