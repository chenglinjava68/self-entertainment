xml������Ȼ��ע�뵽knownMappers �����ݽṹ
Map<Class<?>, MapperProxyFactory<?>>
```
addMapper:61, MapperRegistry (org.apache.ibatis.binding)
/**
mapperRegistry������knownMappers�������ݽṹ����class��mapperproxyfactory�������ݽṹ
*/
addMapper:759, Configuration (org.apache.ibatis.session)
/**
����namespace�ҵ���Ӧ��class,�����û�б����뵽knownMappers���Ϳ�ʼ���
*/
bindMapperForNamespace:441, XMLMapperBuilder (org.apache.ibatis.builder.xml)
/**
��resource·��String�����Ǽ��뵽loadedResources,�������л����resource��·��ȥ����Ӧ��xml�½������ֱ�ǩ,Ȼ�����namespace�󶨶�Ӧ��mapper
*/

parse:96, XMLMapperBuilder (org.apache.ibatis.builder.xml)
/**
����<mapper>���������class��url��resourceֻ����һ��
*/
mapperElement:373, XMLConfigBuilder (org.apache.ibatis.builder.xml)
parseConfiguration:119, XMLConfigBuilder (org.apache.ibatis.builder.xml)
/**
����xml�еĸ��ֱ�ǩ����/configuration��ʼ��Ȼ��mappers��plugins�ȵ�
*/
parse:98, XMLConfigBuilder (org.apache.ibatis.builder.xml)
build:78, SqlSessionFactoryBuilder (org.apache.ibatis.session)
build:64, SqlSessionFactoryBuilder (org.apache.ibatis.session)
main:17, TestMybatis (com.self.entertainment.mybatis.sharding)
```
mybatis�����mapperӳ����Ѿ������ˡ�Ȼ�󴴽�һ��sqlsession��sqlsession.getmapper()Ϊ���class
���ɴ�����

spring��ɨ���Ŀ¼�µ�class������mapperscanָ�����࣬��������@mapper��dao�ӿ�ע���beandifinition��������Ϊmapperfactorybean����ʼ����ʱ��ͻ������getobject�����г�ʼ�����������mapperproxy������౾�����invocationhandler��ʵ���ࣩ�Ĵ������� ���������sql�ĵ����ˡ�MappedStatement  ����xml�з�����id�ͽӿ��еķ������ƶ�Ӧ���������ӳ����ִ�ж�Ӧ��sql

�Ĵ����ӿ�  StatementHandler��ParameterHandler��ResultSetHandler��ExecutorΪ���ǽ��д������