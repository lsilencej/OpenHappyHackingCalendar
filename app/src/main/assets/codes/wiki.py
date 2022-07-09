import json
from urllib.parse import quote

import jsonpath as jsonpath
import requests as requests

if __name__ == '__main__':

    lang = open('./lang.json', 'r', encoding='utf8')
    lang_json = json.load(lang)

    langs = []
    langIndex = 0
    while langIndex < len(lang_json):
        codeLang = lang_json[langIndex]
        try:
            url = 'https://zh.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&uselang=zh-cn&titles=' + \
                  quote(codeLang[
                            'desc'], 'utf-8')
            # 请求头部
            headers = {
                'User-Agent':
                    'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36'
            }
            # 利用请求地址和请求头部构造请求对象,发送请求，获得响应
            response = requests.get(url=url, headers=headers, proxies={'https': 'http://127.0.0.1:7890'})
            response.encoding = 'utf8'
            # 读取响应，获得文本
            wiki = json.loads(response.text)
            desc = jsonpath.jsonpath(wiki, '$..extract')
            codeLang['descWiki'] = desc[0].split('\n')[0]
            langIndex = langIndex + 1
        except Exception as e:
            print("!!!!!!!error!!!!!!!!!!", e)
            continue
        langs.append(codeLang)
    wiki_json = json.dumps(langs, indent=4, ensure_ascii=False)
    print(wiki_json)
    with open('./wiki.json', 'w', encoding='utf8') as f:
        f.write(wiki_json)

